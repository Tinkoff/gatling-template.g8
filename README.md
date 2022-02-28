[![Scala Steward badge](https://img.shields.io/badge/Scala_Steward-helping-blue.svg?style=flat&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAQCAMAAAARSr4IAAAAVFBMVEUAAACHjojlOy5NWlrKzcYRKjGFjIbp293YycuLa3pYY2LSqql4f3pCUFTgSjNodYRmcXUsPD/NTTbjRS+2jomhgnzNc223cGvZS0HaSD0XLjbaSjElhIr+AAAAAXRSTlMAQObYZgAAAHlJREFUCNdNyosOwyAIhWHAQS1Vt7a77/3fcxxdmv0xwmckutAR1nkm4ggbyEcg/wWmlGLDAA3oL50xi6fk5ffZ3E2E3QfZDCcCN2YtbEWZt+Drc6u6rlqv7Uk0LdKqqr5rk2UCRXOk0vmQKGfc94nOJyQjouF9H/wCc9gECEYfONoAAAAASUVORK5CYII=)](https://scala-steward.org)

A [Giter8][g8] template for gatling performance test project

## How to use

`sbt new TinkoffCreditSystems/gatling-template.g8`

Enter the name of your service in the **name** field.

Enter your domain in the **package** field to form the project structure,
e.g. when the value of the package field is set to "ru.tinkoff.load"
the project structure will be ru/tinkoff/load/

**Parameters "name" and "package" are required**. Leave them default or specify yours.

How to install sbt <https://www.scala-sbt.org/1.x/docs/Setup.html>.

## Overriding variable environment

In **Gatling version 3.4.2**, the **typesafe.config** library was updated, where,
for security reasons, they removed the loading of all variables from ENV into the config.
To override a variable from **simulation.conf** you need:
1. By setting the JVM property `-Dconfig.override_with_env_vars=true`;
2. Pass the variable in the `CONFIG_FORCE_variablesName` format, for example `CONFIG_FORCE_intensity=100`.

More details [here](https://github.com/lightbend/config#optional-system-or-env-variable-overrides).

## Known bugs

At the moment, when working in Windows with using SBT version lower than 1.4.1 there is a problem - the temporary .gitignore file is not deleted. This does not affect project creation.

## Template license

Written in 2020 by Chepkasov Sergey s.chepkasov@tinkoff.ru

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
