# Travel System Manager
This application is used to manage several packages that contain details regarding destinations and the activites present in the destinations, It also keeps a record of how many people have enrolled in this package.

## Description
- The application is built with Model layer, Service layers, Response classes, Exceptions and helper functions.
- Model layer has Activity , Destination , PassengerActivity , Travel Package and Passenger
- The service layer contains the business logic
- The Response Layer is used to define Response Classes
- Passenger Class is made using Factory Pattern where Gold, Premium and Stamdard Passenger beans coming from PassengerFactory based on Passenger Type
- The signUp service is used to register a passenger to an activity.
- Helper layer has classes used for printing logic
- Test package contains test cases for Business Layer

## HLD

![HLD](https://github.com/shadan30/TravelSystemDesign/assets/37139445/635ace09-2072-4722-8787-f70f23cc7c70)


## LLD

![LLD drawio](https://github.com/shadan30/TravelSystemDesign/assets/37139445/d8ee2781-ff14-46ce-966e-bc848484b725)

