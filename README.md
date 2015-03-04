Team Foundation Server SDK plugin
============================
Copyright &copy; Stephan Pauxberger

This plugin is based on the Team Foundation Server plugin by Erik Ramfelt, Olivier Dagenais, CloudBees, Inc. and others.

Licensed under [MIT License].

This plugin contains the Microsoft TFS 2013 SDK for Java [TFS-SDK]
 
About
-----
This plugin provides the Microsoft TFS SDK to other plugins (namely TFS and TFS Control plugins).
    
This plugin currently requires the [TFS-SDK] to be present either in the local repository or in some repository
manager.

A Script (prepareSDK.groovy) is provided as convenience. Simply download the SDK into the root folder and run the script.
This will create the necessary artifacts. Afterwards run installSDK.cmd oder installSDK.sh to install them into your local
repository.

TODO
----
Implement additional features like using central Server and credential management, polling etc.


Wiki and Info
-------------
Not yet...

[MIT License]: http://opensource.org/licenses/MIT
[TFS-SDK]: http://www.microsoft.com/en-us/download/details.aspx?id=40785
