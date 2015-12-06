# SpatialDBDemo
Spatial Database Demo
Project specification:
Panthera, the world’s leading cat conservation organization, is focusing on saving endangered
Lions in African national park. They have divided the park into multiple regions and purchased a
number of ambulances to provide emergency health care service to Lions. Ambulances are
parked at various locations in the park to cover the nearby lions. The park also has several
ponds where Lions go to drink water.

I wrote a program to create an application with a GUI, which allows users to interact with the
spatial data. I choose to use Java and JDBC in my java program to
communicate with the oracle database.
Specification:
When the user runs my program, it fetch all regions, all ponds and all lions from the
oracle database and show them in the GUI. Here are the original colors that you should use to
show the geometries:
● boundary/border of each region must be displayed in black color
● interior of each regions must be displayed in white color
● boundary/border of each pond must be displayed in black color
● interior of each pond must be displayed in blue color
● each lion must be displayed in green color
The GUI should interact with the user in the following way:
● Display a checkbox with title “show lions and ponds in the selected region”
● If the checkbox “show lions and ponds in selected region” is checked and the
user clicks on a region, the GUI must show all the lions and ponds inside the
region in red color.
● After clicking on one region, if the user clicks on another region, lions and ponds
in the previously clicked region must be reset to their original colors.
● If the user unchecks the checkbox “show lions and ponds in selected region”, all
the lions and ponds must be reset to their original colors.
