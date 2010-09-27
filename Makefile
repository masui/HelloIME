all:
	ruby tangle.rb
	ant debug
install:
	adb install -r bin/HelloIME-debug.apk
uninstall:
	adb uninstall com.pitecan.helloime
debug:
	adb logcat | grep HelloIME
clean:
	/bin/rm -r -f bin gen src

