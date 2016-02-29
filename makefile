JFLAGS = -g
JC = javac
J = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Position.java \
        Stroke.java \
        Utils.java \
        BinaryFilter.java \
        TextFilter.java \
        Model.java \
        Canvas.java \
        ColorPalette.java \
        PlayBack.java \
        ThicknessPicker.java \
        Doodle.java 

default: classes

run: classes
	$(J) Doodle
	 

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class