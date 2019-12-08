To make an attempt at learning Monads I re-write the code from https://blog.jcoglan.com/2011/03/05/translation-from-haskell-to-javascript-of-selected-portions-of-the-best-introduction-to-monads-ive-ever-read/, in Java.

The code will be available in the javascripttojava package.

Since the Javascript code returns tuples from methods, I use a tuple library.

The example classes appear in the following order in the above mentioned blog post.
* Compose
* ComposeDebuggable
* Bind
* Unit
* Lift