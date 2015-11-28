#!/usr/bin/env sh

size_by_name() {
	case "$1" in
		ldpi)  echo 36 ;;
		mdpi)  echo 48 ;;
		hdpi)  echo 72 ;;
		xhdpi) echo 96 ;;
	esac
}

top=$(dirname $0)

for sz in ldpi mdpi hdpi xhdpi; do
	inkscape \
		-e "$top/src/main/res/drawable-$sz/ic_launcher.png" \
		-w $(size_by_name $sz) \
		"$top/assets/ic_launcher.svg"
done
