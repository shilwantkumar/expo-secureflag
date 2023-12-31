
# expo-secureflag

This module used for enable/disable app preview feature

# API documentation

- [Documentation for the main branch](https://github.com/expo/expo/blob/main/docs/pages/versions/unversioned/sdk/secureflag.md)
- [Documentation for the latest stable release](https://docs.expo.dev/versions/latest/sdk/secureflag/)

# Installation in managed Expo projects

For [managed](https://docs.expo.dev/archive/managed-vs-bare/) Expo projects, please follow the installation instructions in the [API documentation for the latest stable release](#api-documentation). If you follow the link and there is no documentation available then this library is not yet usable within managed projects &mdash; it is likely to be included in an upcoming Expo SDK release.

# Installation in bare React Native projects

For bare React Native projects, you must ensure that you have [installed and configured the `expo` package](https://docs.expo.dev/bare/installing-expo-modules/) before continuing.

### Add the package to your npm dependencies

```
npm install expo-secureflag
```

### Use ExpoSecureflag in your expo app (`App.js`)

```javascript
import * as ExpoSecureflag from "expo-secureflag";
import React from "react";
import { Text, View, Button } from "react-native";

export default function App() {
  const [isEnabled, setIsEnabled] = React.useState(true);
  const disableFunc = () => {
    ExpoSecureflag.activate();
    setIsEnabled(false);
  };

  const enableFunc = () => {
    ExpoSecureflag.deactivate();
    setIsEnabled(true);
  };

  return (
    <View style={{ flex: 1, alignItems: "center", justifyContent: "center" }}>
      <Text>App preview: {isEnabled?'Enabled':'Disabled'}</Text>
      {isEnabled ? (
        <View style={{ width: "200px", marginTop: 20 }}>
          <Button title="Disable App preview" onPress={disableFunc} />
        </View>
      ) : (
        <View style={{ width: "200px", marginTop: 20 }}>
          <Button title="Enable App preview" onPress={enableFunc} />
        </View>
      )}
    </View>
  );
}

```
### Configure for iOS

Run `npx pod-install` after installing the npm package.


### Configure for Android



# Contributing

Contributions are very welcome! Please refer to guidelines described in the [contributing guide]( https://github.com/expo/expo#contributing).

