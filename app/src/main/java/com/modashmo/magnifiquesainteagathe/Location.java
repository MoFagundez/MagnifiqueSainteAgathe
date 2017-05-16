package com.modashmo.magnifiquesainteagathe;

/**
 * Magnifique Sainte-Agathe
 * Created by Mauricio on May 14, 2017
 * <p>
 * Udacity Android Basics Nanodegree
 * Project 6: Tour App
 */

class Location {

    // Class Variables.
    private String locationName;
    private String locationDescription;
    private String locationAddress;
    private String locationDistance;
    private int locationImage;

    /**
    * Object constructor that requires FIVE parameters, including an image (int).
    * <p>
    * Please note that I am NOT using Location Services to determine
    * the distance of the user from the location. I am using a simple
    * String instead since the project rubric does not require the use
    * of GPS services and I understand it will be covered in another topic.
    * <p>
    * @param locationName: Defines the name of the location, i.e.: CN Tower
    * @param locationDescription: Defines a short description for the location, i.e.: Tallest building in Canada, located in Toronto, ON.
    * @param locationAddress: Defines the location address, i.e.: 301 Front St W, Toronto, ON M5V 2T6.
    * @param locationDistance: Defines the distance from the user to the location, i.e.: 5.7 Km.
    * @param locationImage: Defines the image to be placed alongside the location information as shown above.
    * */
    Location(String locationName, String locationDescription, String locationAddress, String locationDistance, int locationImage) {
        this.locationName = locationName;
        this.locationDescription = locationDescription;
        this.locationAddress = locationAddress;
        this.locationDistance = locationDistance;
        this.locationImage = locationImage;
    }

    /**
     * Object constructor requires FOUR parameters, NOT including an image (int).
     * <p>
     * Please note that I am NOT using Location Services to determine
     * the distance of the user from the location. I am using a simple
     * String instead since the project rubric does not require the use
     * of GPS services and I understand it will be covered in another topic.
     * <p>
     * @param locationName: Defines the name of the location, i.e.: CN Tower.
     * @param locationDescription: Defines a short description for the location, i.e.: Tallest building in Canada, located in Toronto, ON.
     * @param locationAddress: Defines the location address, i.e.: 301 Front St W, Toronto, ON M5V 2T6.
     * @param locationDistance: Defines the distance from the user to the location, i.e.: 5.7 Km.
     * */
    Location(String locationName, String locationDescription, String locationAddress, String locationDistance) {
        this.locationName = locationName;
        this.locationDescription = locationDescription;
        this.locationAddress = locationAddress;
        this.locationDistance = locationDistance;
    }

    //Class getters. Setters are not used in this application.
    String getLocationName() {
        return locationName;
    }

    String getLocationDescription() {
        return locationDescription;
    }

    String getLocationAddress() {
        return locationAddress;
    }

    String getLocationDistance() {
        return locationDistance;
    }

    int getLocationImage() {
        return locationImage;
    }

    // String method override with locationName on purpose.
    @Override
    public String toString() {
        return "Location{" +
                "locationName='" + locationName + '\'' +
                '}';
    }
}
