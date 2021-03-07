# Test1
This is demo project which can be imported into Idea or Eclipse to test some functions, like get some "movie data", update some "movie data".
# guide
1. The project is based on SpringBoot and Maven, it is easy to build automaticlly.
2. Run the main method in the class "DemoApplication" to start the project.
3. For easy testing of "get" request with "?" and the parameters, this project has the filter to ignore the special symbol like "{}[ ]"
4. The project uses the 8080 port to run, and of course you can change it in the "application.yml" file.
5. No root URL, just IP + port + business request path, like "http://localhost:8080/movies?search={type:%22animation%22}" 
