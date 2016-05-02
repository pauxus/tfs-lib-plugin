call mvn install:install-file -N -DgroupId=com.microsoft.tfs -DartifactId=tfs-sdk-all -Dversion=14.0.3 -Dpackaging=jar -Dfile=temp/TFS-SDK-14.0.3/redist/lib/com.microsoft.tfs.sdk-14.0.3.jar
call mvn install:install-file -N -DgroupId=com.microsoft.tfs -DartifactId=tfs-sdk-all -Dclassifier=native -Dversion=14.0.3 -Dpackaging=zip -Dfile=temp/tfs-sdk-all-14.0.3-native.zip
call mvn install:install-file -N -DgroupId=com.microsoft.tfs -DartifactId=tfs-sdk-all -Dclassifier=javadoc -Dversion=14.0.3 -Dpackaging=jar -Dfile=temp/tfs-sdk-all-14.0.3-javadoc.jar
