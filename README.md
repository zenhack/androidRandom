A simple android app for generating random numbers.

I wrote this after finding myself in a situation where I needed a
random number between 1 and 17 -- and all of the apps I could find
in F-Droid were dice rollers with fixed die sizes (d4, d6, d8...).

Gives you a pair of text boxes and a button -- push it to generate
a number in the given range.

# Building

Icons are generated from an svg (`assets/ic_launcher.svg`). You need to
have inkscape installed an in your $PATH, then run:

    ./make-icons.sh

The build system is otherwise just the stock gradle android template.

# License

MIT. See COPYING.
