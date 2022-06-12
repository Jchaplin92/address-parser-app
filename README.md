# address-parser-app
- author: Joe Chaplin
- languages/technologies: Java17/Maven
- created: 12th June 2022

## Purpose
- Rearrange addresses to a format ordering Address Lines 1..N, Postcode, Country.

## Installation
### Running as a standalone file
For simplicity a standalone file version of this program is provided in the top-level directory. Run these two commands from the files location in terminal:
1. `javac -cp . StandaloneFileApplication.java`
2. `java StandaloneFileApplication "Crossflight Limited" "ATTN: Guy Dawson" "Crossflight House" "Skyway 14" "Colnbrook" "SL3 0BQ" "United Kingdom"`

### Packaging and running as a JAR file

From address-parser app's top level directory in a command line environment:

1. you must have maven and the Java Runtime Environment installed - check that you are at least version 8 with: `java -version` from command line. Check maven is installed with `maven -version` from command line.
2. `mvn package` to create the jar
3. `java -jar target/address-parser-app-1.0-SNAPSHOT.jar "exampleLine" "example Line 2"`
to run.
