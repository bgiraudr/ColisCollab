#
# Makefile pour compilation/execution de projets Java
#

SOURCES = $$(find ../src -name "*.java")
CLASS_DIR = class
JAVADOC_DIR = javaDoc
DATA_FILE = data
NAME = GIRAUD-RENARD

NAME_TP=$$(echo "$(CURDIR)" | rev | cut -d/ -f2 | rev)

compile: mkdirclass
	@javac -d ../$(CLASS_DIR) $(SOURCES)
	
mkdirclass:
	@mkdir -p ../$(CLASS_DIR)
	
mkdirjavadoc:
	@rm -rf ../$(JAVADOC_DIR)
	@mkdir -p ../$(JAVADOC_DIR)
	
javadoc: mkdirjavadoc compile
	@javadoc -private -author -d ../$(JAVADOC_DIR) $(SOURCES)

run: compile
	@java -classpath ../$(CLASS_DIR) -Xss20000000 $(ARGS)
	
zip compress: compile javadoc
	zip -r ../$(NAME)-$(NAME_TP) ../src/
	zip -r ../$(NAME)-$(NAME_TP) ../$(JAVADOC_DIR)
	zip -r ../$(NAME)-$(NAME_TP) ../$(CLASS_DIR)
	if test -d ../$(DATA_FILE) ; then zip -r ../$(NAME)-$(NAME_TP) ../$(DATA_FILE)/ ; fi
	echo done
	
jar: compile
	if test -d ../$(DATA_FILE) ; then cd ../$(CLASS_DIR) && jar cfm $(NAME_TP).jar Manifest.txt $$(find -name "*.class") $$(find ../$(DATA_FILE) -name "*.*") ; else jar cfm $(NAME_TP).jar Manifest.txt $$(find -name "*.class") ; fi
	@echo done
