call mvn install:install-file -N -DgroupId=com.microsoft.tfs -DartifactId=tfs-sdk-all -Dversion=12.0.2 -Dpackaging=jar -Dfile=temp/TFS-SDK-12.0.2/redist/lib/com.microsoft.tfs.sdk-12.0.2.jar
call mvn install:install-file -N -DgroupId=com.microsoft.tfs -DartifactId=tfs-sdk-all -Dclassifier=native -Dversion=12.0.2 -Dpackaging=zip -Dfile=temp/tfs-sdk-all-12.0.2-native.zip
call mvn install:install-file -N -DgroupId=com.microsoft.tfs -DartifactId=tfs-sdk-all -Dclassifier=javadoc -Dversion=12.0.2 -Dpackaging=jar -Dfile=temp/tfs-sdk-all-12.0.2-javadoc.jar
