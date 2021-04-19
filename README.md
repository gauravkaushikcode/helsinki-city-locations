# helsinki-city-locations

## Project Structure
-- helsinki-city-locations
  -- helsinki-city-locations (Server)
  -- helsinki-locations (Client)
 
## Standalone Deployment
-- helsinki-locations (Client)
  -- cd /helsinki-locations
  -- npm start
-- helsinki-city-locations (Client)
  -- cd /helsinki-city-locations
  -- mvn spring-boot:run
  
### Client
  ## Heroku Client Deployment App Name :- hel-location-client
  -- git subtree push --prefix helsinki-locations hel-heroku-client master

  -- Where hel-heroku-client is remote for	https://git.heroku.com/hel-location-client.git
  
  -- URL --> https://hel-location-client.herokuapp.com/

  ## network.constants holds baseURL
  -- baseURL: "https://hel-location-server.herokuapp.com/"

### Server
  ## Heroku server Deployment App Name :- hel-location-server
  -- git subtree push --prefix helsinki-city-locations-service hel-heroku-server master

  -- Where hel-heroku-server is remote for	https://git.heroku.com/hel-location-server.git
  
  -- URL --> https://hel-location-server.herokuapp.com/locations

  ## For CORS handling Added following to LocationController
  @CrossOrigin(origins = "https://hel-location-client.herokuapp.com")
