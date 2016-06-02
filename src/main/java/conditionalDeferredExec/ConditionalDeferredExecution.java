package conditionalDeferredExec;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.stream.Collectors;

public class ConditionalDeferredExecution {

    public static void main(String[] args) {
        initLogging();

        // deferred execution using Supplier lambda
        // (message is only generated if log level is fine. no need to wrap with if)
        LOG.log(Level.FINE, () -> "files: " + allFilesInDirAsString());

        // instead of:
        if (LOG.isLoggable(Level.FINE)) {
            LOG.log(Level.FINE, allFilesInDirAsString());
        }

    }

    private static String allFilesInDirAsString() {
        try {
            return Files.walk(Paths.get(".")).filter(Files::isRegularFile).map(Path::toFile).map(File::getName)
                    .collect(Collectors.joining(", "));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static final java.util.logging.Logger LOG = java.util.logging.Logger
            .getLogger(ConditionalDeferredExecution.class.getSimpleName());

    // unfortunately the slf4j API does not seem to support deferred execution via lambda, but java.util.logging does so
    // (log4j 2 also supports lazy logging: https://logging.apache.org/log4j/2.0/manual/api.html).
    // private static final org.slf4j.Logger LOG =
    // org.slf4j.LoggerFactory.getLogger(ConditionalDeferredExecution.class);

    private static void initLogging() {
        System.setProperty("java.util.logging.config.file", "src/main/resources/logging.properties");
        try {
            LogManager.getLogManager().readConfiguration();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
