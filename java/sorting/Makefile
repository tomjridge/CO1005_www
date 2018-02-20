SHELL:=bash

-include ../../common.mk

all: class # tmp/sorting_handout.java sorting.tar.gz #$(htmls) 

class: FORCE
	javac -d tmp *.java

mergesort.zip:
	zip -r mergesort.zip mergesort

# String_insertion_sort.java Ins_sort_ops.java Ins_sort_simple.java Intlist_insertion_sort.java Typed_list_functions.java
# just insert this into an oo doc (2 col)
tmp/sorting_handout.java: FORCE
	-rm -f $@
	cat Typed_ops.java Typed_ins_sort.java Typed_string_ops.java Typed_list_ops.java Typed_examples.java > $@
	enscript -2 -o tmp/tmp.ps Typed_ops.java Typed_ins_sort.java Typed_string_ops.java Typed_list_ops.java Typed_examples.java 
	chmod ugo-w $@

DST:=tmp/sorting

sorting.tar.gz: FORCE
	-rm -rf $(DST)
	-mkdir $(DST)
	cp *.java $(DST)
	tar -cvzf $@ -C tmp sorting


run:
#	java -cp tmp String_examples
	java -cp tmp Ins_sort_simple

clean:
	-rm -f *.class
	-mv *.html tmp
	-rm *~

FORCE:
