package expo.modules.secureflag

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import android.content.Context
import android.view.WindowManager

class ExpoSecureflagModule : Module() {
  // Each module class must implement the definition function. The definition consists of components
  // that describes the module's functionality and behavior.
  // See https://docs.expo.dev/modules/module-api for more details about available components.
  override fun definition() = ModuleDefinition {
    // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
    // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
    // The module will be accessible from `requireNativeModule('ExpoSecureflag')` in JavaScript.
    Name("ExpoSecureflag")

    Function("activate"){
      val activity = appContext.activityProvider?.currentActivity
      activity?.runOnUiThread{
        activity?.window?.setFlags(
          WindowManager.LayoutParams.FLAG_SECURE,
          WindowManager.LayoutParams.FLAG_SECURE
        )
      }
    }

    Function("deactivate"){
      val activity = appContext.activityProvider?.currentActivity
      activity?.runOnUiThread{
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
      }
  }
}
