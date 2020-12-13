package com.example.testproject.app

import android.app.Application
import com.example.testproject.app.di.AppComponent
import com.example.testproject.injectionmanager.IHasComponent
import com.example.testproject.injectionmanager.InjectionManager

class TestApplication : Application(), IHasComponent {

    override fun onCreate() {
        super.onCreate()
        InjectionManager.instance.init(this)
        InjectionManager.instance
            .bindComponent<AppComponent>(this)
            .inject(this)                  // после вызова inject этому классу становятся доступны
                                                         // все зависимости, которые предоставляют модули данного компонента?
    }

    override fun getComponent(): Any = AppComponent.Initializer.init()
}