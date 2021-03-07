# Description
This is demo project which can be imported into Idea or Eclipse to test some functions, like get some "movie data", update some "movie data".
# Guide
1. The project is based on SpringBoot(Spring Boot starter V2.4.3) and Maven, it is easy to build automaticlly.
2. JDK Vserion: 1.8.
3. Run the main method in the class "DemoApplication" to start the project.
4. For easy testing of "get" request with "?" and the parameters, this project has the filter to ignore the special symbol like "{}[ ]"
5. The project uses the 8080 port to run, and of course you can change it in the "application.yml" file.
6. No root URL, just IP + port + business request path, like "http://localhost:8080/movies?search={type:%22animation%22}" 
7. I recommend you to use IDEA to run the project.
8. "No DB in the project", just use a simple List to simulate DB, and the Data will be reset if you restart the project.
