# AI-BASED-RECOMMENDATION-SYSTEM

"COMPANY": CODTECH IT SOLUTIONS

"NAME": HINAL ANIL MISTRY

"INTERN ID": CT04DK953

"DOMAIN": JAVA PROGRAMMING

"DURATION": 4 WEEKS

"MENTOR": NEELA SANTHOSH

## DESCRIPTION ##

Task 4 : AI-Based Recommendation System

This task is performed using the ‘Eclipse IDE for Java Developers - 2025-03’.
For easer access of the image, I had created a folder named 'img' and added all the images. Simialarily the data (u.data and the Movies_Final.csv) and the lib (i.e all the .jar files) were added into the project in the eclipse IDE.

This Java program develops a Movie Recommender System with a graphical interface using Java Swing. This system uses collaborative filtering through Apache Mahout, which is an open-source library for building large-scale recommendation systems. This system is meant to offer personalized recommendations of films to users based on what similar users do.

The single main aim of this program is to enable the user to choose their profile from a list and then see five movie recommendations. The application has a minimal and simple interface with a black background and photos of the recommended films, movie titles, and the degree of how much they can enjoy them. 
When you run the program, it creates a main window that's also known as Movie Recommender. At the top, there is a big label labeled with the name of the app. There is a dropdown that comes with the usernames for the users to choose from. If you click on the "Get Recommendation" button, the app uses user similarity information to generate movie recommendations and then displays the recommendations on the screen.

Apache Mahout offers the foundation for the recommendation engine, which utilizes collaborative filtering methods. Below is the description of how the system functions:

1. Data Model(dm) Loading: The system loads user-movie interaction information from a CSV file (MoviesFinal.csv) via Mahout's FileDataModel.

2. Similarity Calculation: It computes with LogLikelihoodSimilarity(sim), a statistical method for assessing the similarity between users based on what they watch.

3. Neighborhood Building: The NearestNUserNeighborhood(nei) returns the five nearest users who share the same preferences as the chosen user.

4. Recommendation Generation: GenericUserBasedRecommende(recommender) returns a list of the recommended films for the chosen user based on what their closest neighbors like.

5. Preference Estimation: Mahout estimates a preference score (estimatedPref) per suggested film showing how suitable it is for the user's tastes.

The GUI is built using different Swing components. JLabel is used for constant text, i.e., movie names, titles, and preference values. JComboBox(cb) shows a list of the user names. JButton triggers the process of suggesting recommendations. ImageIcon and JLabel show images of movie posters.

The organization places things in certain positions (setBounds) instead of using a layout manager. This gives complete control over placement. After it makes a recommendation, the UI changes to show movie posters, titles, and preference ratings below the heading.

The application uses:
     • A list of movie titles and their respective picture files.
     • A list of usernames that are different users with different tastes.

When a user makes a choice, the system takes the top five movie recommendations from Mahout's output. The system resized and displays their posters in the interface. Below each poster, you see the name of the movie as well as its predicted rating. This gives the users a complete picture both and.

This Movie Recommender System developed in Java uses Apache Mahout's collarbrative-based filtering to supply intelligent personalized recommendations of movies. Adding visually aesthetic features like the movie posters will make the system interactive while creating a balance between utility and looks.

## OUTPUT ##

Before Selecting the User :

![Image](https://github.com/user-attachments/assets/c11047c2-28d8-4389-bb7e-87efaf086015)

After Selecting the User:(Note you can change mutliple time the user).

![Image](https://github.com/user-attachments/assets/e505e0b6-e3b6-42dd-ac0c-2d471d2a6f0c)

![Image](https://github.com/user-attachments/assets/85e82aaf-80b0-439e-88ca-48e291a57910)


