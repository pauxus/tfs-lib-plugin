/**
 * Helper script to prepare the downloaded SDK as artifacts suitable for installing into local repository.
 * 
 * Usage: Download the SDK from http://www.microsoft.com/en-us/download/details.aspx?id=40785 and place it beside
 * this script.
 * 
 * Then execute the script. 
 * 
 * Finally, install the generated artifacts using the provided mvn command. 
 */

def ant = new AntBuilder()

File sdkZip = new File("TFS-SDK-12.0.2.zip")

if (!sdkZip.isFile()) {
    println "Please dowload the SDK first."
    System.exit(1)
}

println "Unzipping SDK..."
ant.unzip(src: sdkZip, dest: 'temp/')

File sdkDir = new File('temp/TFS-SDK-12.0.2')

println "zipping natives..."
ant.zip(destfile: 'temp/tfs-sdk-all-12.0.2-native.zip', basedir: new File(sdkDir, 'redist'), excludes: 'lib/*')

println "zipping javadoc"
ant.jar(destfile: 'temp/tfs-sdk-all-12.0.2-javadoc.jar', basedir: new File(sdkDir, 'docs/javadoc'))


println "Now call installSDK.sh / installSDK.cmd"

