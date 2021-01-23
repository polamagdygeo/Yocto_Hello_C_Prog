SUMMARY = "First hellow world app"
PRIORITY = "optional"
SECTION = "examples"
HOMEPAGE = "https://github.com/polamagdygeo/Yocto_Hello_C_Prog"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4db76e796630c8bbe805d3ed85450397"

SRCREV = "2c9092eceabb9511e967ff5e3a6491386dadfbc5"

SRC_URI = "git://github.com/polamagdygeo/Yocto_Hello_C_Prog.git;protocol=https;branch=master"

SRC_URI[md5sum] = "9e827778cccf9a22f937d979f276ba5d"

S = "${WORKDIR}/git"

# The following variables should be set to accomodate each application
BAREMETAL_BINNAME ?= "hello_baremetal_${MACHINE}"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
	oe_runmake
}

# Install binaries on the proper location for baremetal-image to fetch and deploy
do_install(){
    install -d ${D}/${base_libdir}/firmware
    install -m 755 ${B}/build/helloworld.bin ${D}/${base_libdir}/firmware/${BAREMETAL_BINNAME}.bin
}

FILES_${PN} += " \
    ${base_libdir}/firmware/${BAREMETAL_BINNAME}.bin \
"
