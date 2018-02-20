SHELL:=bash

all: class_

class_: 
	mkdir -p bin
	javac -d bin src/*.java

run_:
	java -cp bin MergeSort

clean:
	-rm -f bin/*.class

