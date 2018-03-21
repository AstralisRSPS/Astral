package com.asteria;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.asteria.net.NetworkConstants;
import com.asteria.utility.LoggerUtils;
import com.google.common.base.Preconditions;

/**
 * The main class that will create and bind the {@link Bootstrap},
 * effectively putting the server online.
 *
 * @author lare96 <http://github.com/lare96>
 */
public final class Server {
	//xd

    /**
     * The name of this server.
     */
    public static final String NAME = "Smite.io";

    /**
     * The flag that determines if debugging messages should be printed or not.
     */
    public static final boolean DEBUG = false;

    /**
     * The logger that will print important information.
     */
    private static Logger logger = LoggerUtils.getLogger(Server.class);

    /**
     * The default constructor, will throw an
     * {@link UnsupportedOperationException} if instantiated.
     *
     * @throws UnsupportedOperationException
     *             if this class is instantiated.
     */
    private Server() {
        throw new UnsupportedOperationException("This class cannot be instantiated!");
    }

    /**
     * The main method that will put the server online.
     */
    public static void main(String[] args) {
        try {
            Preconditions.checkState(args.length == 0, "No runtime arguments needed!");
            logger.info("Launching Smite! Please wait...");
            Bootstrap bootstrap = new Bootstrap(NetworkConstants.PORT);
            bootstrap.bind();
            logger.info("The Bootstrap has been bound, " + NAME + " is now online!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "[ERROR] : Binding the Bootstrap!", e);

            // No point in continuing server startup when the
            // bootstrap either failed to bind or was bound
            // incorrectly.
            System.exit(1);
        }
    }
}