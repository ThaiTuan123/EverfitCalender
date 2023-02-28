package com.example.everfittest.base

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.everfittest.dialogManager.DialogManager
import com.example.everfittest.dialogManager.DialogManagerImpl

abstract class BaseActivity<V : ViewBinding, VM : BaseViewModel> :
    AppCompatActivity() {

    protected lateinit var viewModel: VM
    protected lateinit var viewBinding: V

    private lateinit var dialogManager: DialogManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = inflateViewBinding(layoutInflater)
        viewModel = getBaseViewModel()
        dialogManager = DialogManagerImpl(this)
        setContentView(viewBinding.root)
        initView()
        initData()
    }

    override fun onStart() {
        super.onStart()
        registerLiveData()
    }

    private fun showLoading() {
        dialogManager.showLoading()
    }

    private fun hideLoading() {
        dialogManager.hideLoading()
    }

    abstract fun inflateViewBinding(inflater: LayoutInflater): V
    abstract fun initView()
    abstract fun initData()

    open fun registerLiveData() {
        viewModel.run {
            isLoading.observe(this@BaseActivity) {
                if (it) showLoading() else hideLoading()
            }
        }
    }

    /**
     * Show title action bar
     *
     * @param title - String
     */
    protected open fun changeActionBar(title: String?) {
        supportActionBar!!.title = title
    }

    /**
     * Toast shown for short period of time
     * Toast.LENGTH_SHORT - Toast delay 2000 ms predefined
     *
     * @param message - String
     */
    protected open fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Toast shown for short period of time
     * Toast.LENGTH_SHORT - Toast delay 2000 ms predefined
     *
     * @param message - int
     */
    protected open fun showToast(message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    open fun getBaseViewModel(): VM {
        return ViewModelProvider(this)[getViewModelClass()]
    }

    abstract fun getViewModelClass(): Class<VM>
}
