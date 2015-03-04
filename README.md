Team Foundation Server SDK plugin
============================
Copyright &copy; Stephan Pauxberger

This plugin is based on the Team Foundation Server plugin by Erik Ramfelt, Olivier Dagenais, CloudBees, Inc. and others.

Licensed under [MIT Licence].

This plugin contains the Microsoft TFS 2013 SDK for Java [TFS-SDK]
 
About
-----
This plugin provides the Microsoft TFS SDK to other plugins (namely TFS and TFS Control plugins).
    
We use some heavy "Maven Magic" to workaround the fact that we cannot simply provide the Microsoft SDK as download 
(due to unclear licensing issues). Therefore we do our own installation of the sdk (without deploying), which
we consume directly in the plugin part.

The result is a buildable version which should be safe on license terms, but also refrains from using system scope,
which brings its one problems.

Consumers
---------
Consumer plugins still need to have their own access to the sdk in order to work (usually still system scoped). They
could use a short code snippet to download the plugin and extract the sdk.

TODO
----
Convert to gradle plugin to remove all that Maven Voodoo.


Wiki and Info
-------------
Not yet...

[MIT License]: http://opensource.org/licenses/MIT
[TFS-SDK]: http://www.microsoft.com/en-us/download/details.aspx?id=40785
