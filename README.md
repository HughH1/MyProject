# MyProject

My project is a **C.R.U.D.**, create, read, update, delete application
that can persist data inputted from the website to database. 



The project is called Skate Tricks and is a website which
allows the user to create a new trick, view the trick by searching for it, update
a trick by searching by name, and deleting said trick by searching for the
trick then deleting it. The website has a navigation bar at the top that the
user can click on to the relevant page. For the creation of the website I used HTML,
CSS (bootstrap) and vanilla JavaScript. For the data to can sent to the
database it first is converted into a JSON string then a connection to the JDBC
is opened and the data is sent via a HTTP request such as PUT for an update in
the JDBC if the request is ok it will return a HTTP response. If the request is
ok it will return an HTTP status code 200, successful codes are from 200 to
below 300. The website then performs a check on the HTTP status code if it's successful
it performs the action such as sending data or returning data depending on the HTTP
method. 



In the JDBC there are a few things happening, starting with what
it does with an incoming JSON string which is sent to a path. The path that
it's sent to is a method that receives this string as a parameter input then calls
the trick repository interface which is injected into the concretion of the "TrickDB"
class which depending what method is called say "findTrick" creates new
instance of trick from the "Trick.class" the object is then set to
the value retrieved from the "Trick.class" using the entity manager
has the object is an entity and is able to be persisted to the database. In the
"TrickDB.class" most of the methods are transactional meaning they if
they fail part way through the transaction is discarded and the database is
unchanged. The only method that doesn't need a transactional is the for viewing
is nothing is being changed.  The
database I have used is H2 along Wildfly to send the data with hibernate as a dependency.
 



To setup my project you will need to have a few things. Firstly,
you will need to download maven. Once you have setup maven; in your command terminal
locate your project into your project at the top level and type in "mvn install"
or if you are on windows, you can use the file explore then in the path address
bar type in "cmd" then type in the command. What this doing is downloading
all the dependencies that your project requires. The dependencies are located
inside the pom.xml file. You will now need to download and set up H2 server and
Wildfly. Now you will need to run the H2 database. Navigate to the H2 directory
then to /bin inside there open up your terminal as stated before, type the
command "java -jar h2-VERSION.jar replace "VERSION" with the version
you have. **Don't** close the window that pops up. Now that they're set up in the
project folder navigate to /target/SkateTricks-1.0.war copy the file then navigate
to the Wildfly/standalone/deployments/ then paste in the war file. Navigate
back two directories then go to /bin/ and search for the
"standalone.bat" file and run it, this will run the server and deploy
the war file. Now your local server is up and running, on your browser of choice
in the url type in "localhost:8082" and you should be able to configure
and view your database from there. 




