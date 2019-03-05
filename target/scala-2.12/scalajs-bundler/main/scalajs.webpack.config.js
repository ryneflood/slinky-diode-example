module.exports = {
  "entry": {
    "diode-example-fastopt": ["/home/ryne/tmp/diode-example/target/scala-2.12/scalajs-bundler/main/diode-example-fastopt-entrypoint.js"]
  },
  "output": {
    "path": "/home/ryne/tmp/diode-example/target/scala-2.12/scalajs-bundler/main",
    "filename": "[name]-library.js",
    "library": "ScalaJSBundlerLibrary",
    "libraryTarget": "var"
  },
  "mode": "development",
  "devtool": "source-map",
  "module": {
    "rules": [{
      "test": new RegExp("\\.js$"),
      "enforce": "pre",
      "use": ["source-map-loader"]
    }]
  }
}