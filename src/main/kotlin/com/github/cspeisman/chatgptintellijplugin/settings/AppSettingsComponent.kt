package com.github.cspeisman.chatgptintellijplugin.settings

import com.intellij.openapi.ui.ComboBox
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.ComboBoxModel
import javax.swing.DefaultComboBoxModel
import javax.swing.JComponent
import javax.swing.JPanel


class AppSettingsComponent {
    private val myMainPanel: JPanel
    private val myApiKey = JBTextField()
    private val myChatGptModel = JBTextField()
    private val myEnableChineseBox = ComboBox<String>()

    init {
        // 初始化下拉框
        val comboBoxModel = DefaultComboBoxModel<String>()
        comboBoxModel.addElement("否")
        comboBoxModel.addElement("是")
        myEnableChineseBox.model = comboBoxModel

        myMainPanel = FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("ChatGpt Api Key:"), myApiKey, 1, false)
            .addLabeledComponent(JBLabel("ChatGpt Model: "), myChatGptModel, 1, false)
            .addLabeledComponent(JBLabel("Enable Chinese:"), myEnableChineseBox, 1, false) // 添加下拉框组件
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    val panel: JPanel
        get() = myMainPanel
    val preferredFocusedComponent: JComponent
        get() = myApiKey

    var apiKey: String?
        get() = myApiKey.text
        set(newText) {
            myApiKey.text = newText
        }
    var chatGptModel: String?
        get() = myChatGptModel.text
        set(newText) {
            myChatGptModel.text = newText
        }

    var enableChinese: String?
        get() = myEnableChineseBox.selectedItem as String
        set(newText) {
            myEnableChineseBox.selectedItem = newText
        }
}
