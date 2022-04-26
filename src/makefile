run: jar
	java -jar contactbook.jar
	
bat: classes
	jar -cvfm contactbook.bat manifest.txt *.*

jar: classes
	jar -cvfm contactbook.jar manifest.txt *.*

classes: *.java
	javac *.java

clean:
	rm *.class
	rm *.txt
	rm *.dat

debug: Main.class
	jdb Main
