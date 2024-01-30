Greeting to anyone reading this.

This is my Fullstack Cinema Web App that's being developed using Java Spring Boot and ReactJS. 

My main goal is to simulate a Cinema Web App that supports both ADMIN and regular USER actions.
- USER actions: making an account, logging in/out, changing the password, browsing available films, buying tickets etc.
- ADMIN actions: adding new films, projections, deleting them, setting and changing the prices for tickets and so on.

The last step is to make the Web App responsive.

Classes used for modelling on the Back End:
- Auditorium (Hall)
- Film
- Genre
- Projection
- ProjectionType(2D, 3D, 4D)
- Seat
- Ticket
- User

The usernames and passwords for the existing users are the same: 'miroslav'(ADMIN) , 'petar' and 'tamara'.

Packages being used (for now):
- axios
- react-router-dom
- tanstack/react-query

Plan on adding later on: 
- react-redux
- millionjs
- tailwind (maybe)

Change logs:
29.01.2024 - I have opted not to rely on the loader and action methods from react-router-dom package, instead I'm going to focus on implementing React Query features, which will require changing the code altogether. I left the old Front End code in the FrontEnd folder, the new code is in the FrontEndMain folder, so run the app from that folder instead.

