A [Giter8][g8] template for gatling performance test project

How to use
----------------
`sbt new TinkoffCreditSystems/gatling-template.g8`

Enter the name of your service in the **name** field.

Enter your domain in the **package** field to form the project structure,
e.g. when the value of the package field is set to "ru.tinkoff.load"
the project structure will be ru/tinkoff/load/

**Parameters "name" and "package" are required**. Leave them default or specify yours.

How to install sbt <https://www.scala-sbt.org/1.x/docs/Setup.html>.

Known bugs
----------------
At the moment, when working in Windows with
using SBT version lower than 1.4.1 there is a problem - the temporary `.gitignore` file is not deleted.
This does not affect project creation.

Template license
----------------
Written in 2020 by Chepkasov Sergey s.chepkasov@tinkoff.ru

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
