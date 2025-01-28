**Requirements:**
Threaded Entities: Any entity that wants to access shared resources must be a thread.

Synchronization: The program should use synchronization mechanisms provided by the java.util.concurrent and java.util.concurrent.locks libraries.

Avoid Certain Constructs: Do not use synchronized, volatile, BlockingQueue, or other collections with limited thread safety.

Structure and Naming: Classes and other entities in the application must be logically structured in packages and have names reflecting their functionality.

State Pattern: Use the State pattern to describe the states of an object, but only if there are more than two states.

Thread Creation with Callable: When possible, use Callable for creating threads, as opposed to Runnable or Thread.

Avoid Thread.sleep: Do not use Thread.sleep for thread synchronization; instead, use the TimeUnit enum.

Object Initialization from File: Object initialization data should be read from a file, and the data in the file must be valid.

Thread-safe Singleton: The application must have a thread-safe Singleton. Do not use the enum approach for its creation.

Logging: Use Log4J2 or any other logging framework for logging.

Output Using Main: It is allowed to use the main method to output the results of the threads' operations.

**11. Orbital Base - Port Operations**
Ships arrive at the port to unload and/or load various types of valuable ores from asteroids and the Moon, and dock at the piers. Each pier can accommodate only one ship at a time.

The ores are transferred from the ship to the port's warehouse or to a factory for processing or enrichment, or from the factory to the ship, or from the port to the ship. The capacity of the port's warehouse, the factory, and the ship must be considered when managing these operations.

Each ship must be serviced and processed accordingly.
