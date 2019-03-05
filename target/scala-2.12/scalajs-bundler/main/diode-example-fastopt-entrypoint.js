module.exports = {
  "require": (function(x1) {
    return {
      "react": require("react"),
      "react-proxy": require("react-proxy"),
      "resources/index.css": require("resources/index.css"),
      "react-dom": require("react-dom"),
      "resources/logo.svg": require("resources/logo.svg"),
      "resources/App.css": require("resources/App.css")
    }[x1]
  })
}