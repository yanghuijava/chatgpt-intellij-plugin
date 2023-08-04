package com.github.cspeisman.chatgptintellijplugin.settings

import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class AppSettingsConfigurable : Configurable {
    private var mySettingsComponent: AppSettingsComponent? = null


    override fun createComponent(): JComponent {
        mySettingsComponent = AppSettingsComponent()
        return mySettingsComponent!!.panel
    }

    override fun isModified(): Boolean {
        val settings: AppSettingsState = AppSettingsState.instance
        var modified = mySettingsComponent!!.apiKey != settings.apiKey
        modified = modified or (mySettingsComponent!!.chatGptModel != settings.model)
        modified = modified or (mySettingsComponent!!.enableChinese != settings.enableChinese)
        return modified
    }


    override fun apply() {
        val settings: AppSettingsState = AppSettingsState.instance
        settings.apiKey = mySettingsComponent!!.apiKey!!
        settings.model = mySettingsComponent!!.chatGptModel!!
        settings.enableChinese = mySettingsComponent!!.enableChinese!!
    }

    override fun reset() {
        val settings: AppSettingsState = AppSettingsState.instance
        mySettingsComponent!!.apiKey = settings.apiKey
        mySettingsComponent!!.chatGptModel = settings.model
        mySettingsComponent!!.enableChinese = settings.enableChinese
    }

    override fun disposeUIResources() {
        mySettingsComponent = null
    }

    override fun getDisplayName(): String {
        return "ChatBot: ChatGpt Settings"
    }
}
