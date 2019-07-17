# popuprating

Support

Minimal API 15
------------------------------------------------------------------------------------------------------------------------------
Installing

Tambahkan repository di build.gradle

repositories {
    maven { url "https://jitpack.io" }
}

Dan tambahkan dependencies

dependencies {
    implementation 'com.github.rafligoodramadhan:popuprating:0.0.1'
}

------------------------------------------------------------------------------------------------------------------------------
Sample Code

PopupRating popupRating = new PopupRating(MainActivity.this);

/*Popup akan kelaur sesaui value yang di isikan*/

int value  = 5;
popupRating.setBukaSetiap(value);
