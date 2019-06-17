# MyProject

My project is a **C.R.U.D.**, create, read, update, delete application
that can persist data inputted from the website to database. 

The project is called Skate Tricks and is a website which
allows the user to create a new trick, view it by searching for it, update it
after searching for it by name and deleting said trick again by searching for
the trick. For the creation of the website I used HTML, CSS (bootstrap) and vanilla
JavaScript. 

### What goes on
For the data to be sent/retrieved/updated/deleted to the
database, it is first converted to a JSON string then a connection to the JDBC
is opened and the data is sent, with the help of the HTTP request methods in RESTful
web services such as PUT. If the request is ok, it will return an HTTP status
code response. If the request is ok it will return an HTTP status code 200,
successful codes are within 200. The website then performs a check on the HTTP
status code if it's successful it performs the action such as sending or
returning data depending on the HTTP method. 

In the JDBC there are a few things happening, starting with
what goes on with an incoming JSON string which is sent to a URI (Uniform
Resource Identifier). Depending on what the URI is it will be sent to one of
the matching methods within the "TrickDB" class. For instances let's
say the HTTP GET method is sent which calls the method "findTrick". Inside
this method a new instance of the "Trick.class" (which is an entity) is
created called "trick". The object is set to the value retrieved from
the "Trick.class" using the entity manager has the object is an
entity and can be persisted to the database. In the "TrickDB.class"
most of the methods are transactional meaning they if they fail part way through
the transaction is discarded and the database is unchanged. The only method
that doesn't need a transactional is the for viewing is nothing is being
changed. 


### How to setup
To setup my project you will need to download and install
the following. 
1. Maven
2. Wildfly
3. H2 Database      


#### Maven
Starting with maven. In your command terminal (for Windows
users in your file explorer) locate your project into your project at the top
level (Window users in file explorer type in cmd into the directory bar) and type
in "mvn install". What this doing is downloading all the dependencies
that your project requires using Maven along with building the war file. All
the project's dependencies are located inside the pom.xml file. 


#### H2 Database
Now you will need to run the H2 database. In your terminal (or
file explorer) navigate to the H2 directory, then to, /bin inside there (Window
users in file explorer open the terminal now) you will need to type in the command
"java -jar h2-VERSION.jar replace "VERSION" with the version you
have. **Don't** close the window that pops up. 


#### Wildfly
Navigate to the top project directory then to /target/SkateTricks-1.0.war
copy the file war file then navigate to the Wildfly/standalone/deployments/
then paste in the war file. Navigate back to the top-level directory then go to
/bin/ and search for the "standalone.bat" file and run it, this will
run the server and deploy the war file. Now your local server is up and
running, open your browser of choice and in the URL type in "localhost:8082"
and you should be able to configure and view your database from there.


### Expansion  
Now you have the project set up you can add additional entities
in the source src/main/java folder, model package and create new class. Still
in the src/main/java folder there are two more packages you will need to add to,
these are repository and rest. Repository package contains the DB class and
Repository interface you will need to add for a new entity. Finally, you will
need to add in another endpoint class which is where the URI is directed to. Now
you can expand open my project.
