package jenkins.plugins.tfslib;

import com.microsoft.tfs.core.TFSTeamProjectCollection;
import hudson.ExtensionPoint;
import hudson.Plugin;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 * This class provides a static initializer to allow tfs plugins to automatically load the native libraries.
 * 
 * Thia can also be used to perform some form of cleanup later. 
 *
 */
public abstract class TfsSdkLibAccess {

    private static final String nativeFolderPropertyName = "com.microsoft.tfs.jni.native.base-directory";

    static {
        ensureNativeLibrariesConfigured();
    }
    
    public static synchronized void ensureNativeLibrariesConfigured() {
        final String nativeFolder = System.getProperty(nativeFolderPropertyName);
        if (nativeFolder == null) {
            final Class<TFSTeamProjectCollection> metaclass = TFSTeamProjectCollection.class;
            final ProtectionDomain protectionDomain = metaclass.getProtectionDomain();
            final CodeSource codeSource = protectionDomain.getCodeSource();
            if (codeSource == null) {
                // TODO: log that we were unable to determine the codeSource
                return;
            }
            final URL location = codeSource.getLocation();
            // inspired by http://hg.netbeans.org/main/file/default/openide.filesystems/src/org/openide/filesystems/FileUtil.java#l1992
            final String u = location.toString();
            URI locationUri;
            if (u.startsWith("jar:file:") && u.endsWith("!/")) {
                locationUri = URI.create(u.substring(4, u.length() - 2));
            }
            else if (u.startsWith("file:")) {
                locationUri = URI.create(u);
            }
            else {
                // TODO: log that we were unable to determine location from codeSource
                return;
            }
            final File pathToJar = new File(locationUri);
            final File pathToLibFolder = pathToJar.getParentFile();
            final File pathToNativeFolder = new File(pathToLibFolder, "native");
            System.setProperty(nativeFolderPropertyName, pathToNativeFolder.toString());
        }
    }

}
