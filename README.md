# JSF PrimeFaces demo

This is a demo maven project that uses <strong>JSF with PrimeFaces</strong>. <strong>Please make sure that project is runnable with the command below.</strong>

You can execute the sample with <strong>mvn jetty:run</strong> command and hit <strong>http://localhost:8080/jsf-primefaces</strong> to run the page.

### JSF Versions
***

Per default the application uses Mojarra 2.2.x. 
You can also use other versions with the available maven profiles: myfaces22, myfaces23, myfaces23next, mojarra23

`mvn clean jetty:run -Pmyfaces22`

`mvn clean jetty:run -Pmyfaces23`

`mvn clean jetty:run -Pmyfaces23next`

`mvn clean jetty:run -Pmojarra22`

`mvn clean jetty:run -Pmojarra23`

### Server Port
***

By default the application runs on port 8080 but if you would like to use a different port you can pass `-Djetty.port=5000` like:

`mvn clean jetty:run -Djetty.port=5000`

### Jakarta EE10 Version
***

The branch `jakarta` contains a PrimeFaces Test setup to run again Jakarta EE10 profile using Jetty 11. You can also use other versions with the available maven profiles: mojarra40, myfaces40

`mvn clean jetty:run -mojarra40`

`mvn clean jetty:run -myfaces40`

### Visual Studio Code Quickstart
***

See the [quickstart guide for running in Visual Studio Code](./vscode-quickstart.md) for more information.
