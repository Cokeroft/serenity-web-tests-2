# Serenity Web Tests

Acceptance/UI tests for the RealWorld “Conduit” app using **Serenity BDD + Cucumber + Selenium**.

This project targets the Django REST Framework + Angular implementation of RealWorld. You can run the app under test locally **with Docker** and execute this test suite against it.

---

## Contents

- [Quick Start](#quick-start)
- [Running the System Under Test (Docker)](#running-the-system-under-test-docker)
- [How to Run the Tests](#how-to-run-the-tests)
  - [Filter by Cucumber tags](#filter-by-cucumber-tags)
  - [Headless/CI friendly run](#headlessci-friendly-run)
  - [Common overrides](#common-overrides)
  - [Parallel execution (optional)](#parallel-execution-optional)
- [Reports](#reports)
- [Dependencies / Requirements](#dependencies--requirements)
- [Configuration: `PropertyManager.java`](#configuration-propertymanagerjava)
  - [Adding a new property](#adding-a-new-property)
  - [Overriding values at runtime](#overriding-values-at-runtime)
- [Troubleshooting](#troubleshooting)

---

## Quick Start

```bash
# 1) Clone the tests
git clone https://github.com/Cokeroft/serenity-web-tests-2.git
cd serenity-web-tests-2

# 2) Start the app under test (in another terminal)
#    See "Running the System Under Test (Docker)" below.

# 3) Run the test suite (example tag)
mvn clean verify "-Dcucumber.filter.tags=@prophetx"
```

---

## Running the System Under Test (Docker)

We test against the RealWorld Django + Angular app here:

> https://github.com/NemTam/realworld-django-rest-framework-angular

That repo ships with a `docker-compose.yml` so you can bring the whole stack up quickly:

```bash
# In a separate folder from this test repo:
git clone https://github.com/NemTam/realworld-django-rest-framework-angular.git
cd realworld-django-rest-framework-angular

# Start everything (backend + frontend)
docker compose up -d
```

Once running, the Angular app is available at `http://localhost:4200` by default (as documented in the repo’s README), and the Django backend at `http://localhost:8000` when run locally outside Docker; with Docker, the front end is what you’ll hit in the browser/tests at `:4200`.

> Tip: `docker compose logs -f` and `docker compose ps` are handy if something fails to start.

---

## How to Run the Tests

### Filter by Cucumber tags

Your command (works with any tag you want):

```bash
mvn clean verify "-Dcucumber.filter.tags=@prophetx"
```

More examples:

```bash
# Multiple tags: AND
mvn clean verify "-Dcucumber.filter.tags=@login and @smoke"

# Multiple tags: OR
mvn clean verify -Dcucumber.filter.tags="@smoke or @regression"

# Exclude a tag
mvn clean verify -Dcucumber.filter.tags="not @wip"
```

### Headless/CI friendly run

```bash
mvn clean verify   -Dwebdriver.driver=chrome   -Dchrome.switches="--headless=new --disable-gpu --window-size=1920,1080"
```

### Common overrides

```bash
# Point tests to a different base URL (e.g., your remote env)
mvn clean verify -DbaseUrl="http://localhost:4200"

# Bump timeouts if your machine is slow
mvn clean verify -DimplicitWait=2000 -DexplicitWait=10000

# Choose browser
mvn clean verify -Dwebdriver.driver=chrome
```

### Parallel execution (optional)

If you’ve enabled parallel forks in your Maven `surefire`/`failsafe` config, you can also pass:

```bash
mvn clean verify -Dserenity.concurrent.executions=4
```

---

## Reports

After a run, open:

```
target/site/serenity/index.html
```

Serenity generates rich, navigable reports with scenario, step, and screenshot details.

---

## Dependencies / Requirements

- **Java**: JDK 17+ (11+ works in many setups; use 17 if available)
- **Maven**: 3.8+  
- **Docker Desktop** (or Docker Engine) + **Docker Compose** for the RealWorld app
- **Browser**: Chrome (default)  
  - WebDriver binaries are usually managed automatically; if you pin specific versions, ensure they match the installed browser.

---

## Configuration: `PropertyManager.java`

`PropertyManager.java` centralizes test configuration. Typical values include:

- `baseUrl` — where the AUT is hosted (defaults to `http://localhost:4200`)
- `implicitWait`, `explicitWait` — WebDriver timeouts
- feature toggles, credentials, API endpoints, etc.

Example:

```java
public final class PropertyManager {

    private PropertyManager() {}

    private static final String BASE_URL =
        System.getProperty("baseUrl", "http://localhost:4200");

    private static final int IMPLICIT_WAIT =
        Integer.parseInt(System.getProperty("implicitWait", "1000"));

    private static final int EXPLICIT_WAIT =
        Integer.parseInt(System.getProperty("explicitWait", "5000"));

    public static String baseUrl()       { return BASE_URL; }
    public static int implicitWaitMs()   { return IMPLICIT_WAIT; }
    public static int explicitWaitMs()   { return EXPLICIT_WAIT; }

    public static String username() {
        return System.getProperty("username",
               System.getenv().getOrDefault("TEST_USERNAME", "demo@conduit.local"));
    }

    public static String password() {
        return System.getProperty("password",
               System.getenv().getOrDefault("TEST_PASSWORD", "password"));
    }
}
```

### Adding a new property

1. **Declare it** with a sensible default and a system property override:

   ```java
   private static final String API_URL =
       System.getProperty("apiUrl", "http://localhost:8000");
   public static String apiUrl() { return API_URL; }
   ```

2. **Use it** from your steps/tasks:

   ```java
   String api = PropertyManager.apiUrl();
   ```

3. **Override at runtime**:

   ```bash
   mvn clean verify -DapiUrl="https://staging.api.mycompany.com"
   ```

### Overriding values at runtime

- **System properties (preferred)**:
  ```bash
  mvn clean verify -DbaseUrl="http://localhost:4200" -DimplicitWait=2000
  ```
- **Environment variables**:
  ```bash
  export TEST_USERNAME="ci-user"
  export TEST_PASSWORD="s3cret"
  mvn clean verify
  ```

---

## Troubleshooting

- **Docker app not reachable**
  - Confirm containers: `docker compose ps`
  - Inspect logs: `docker compose logs -f`
  - Verify front end on `http://localhost:4200`
- **WebDriver version issues**
  - Ensure Chrome is installed/updated.
- **Timing flakiness**
  - Increase `explicitWait`/`implicitWait`.
- **Parallel runs fail**
  - Disable parallel or isolate test data.

---

### Next Steps

You can extend this project with:
- A `Makefile` for simplified commands.
- A `docker-compose.test.yml` to containerize the tests.
- GitHub Actions CI integration for automated reporting.
