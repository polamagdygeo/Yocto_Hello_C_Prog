BUILDDIR=build/
executable=helloworld

# Target rules
all: build

# Create a raw binary from ELF
build: builddir
	${CC} main.c -o ${BUILDDIR}${executable}.bin

builddir:
	mkdir -p build/

clean:
	rm -f ${BUILDDIR}*.elf
	rm -f ${BUILDDIR}*.bin
