package com.pack.safflower.viewmodel.navigation.home
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.blankj.utilcode.util.SizeUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import com.pack.safflower.R
import com.pack.safflower.adapter.GridAdapter
import com.pack.safflower.base.BaseViewModel
import com.pack.safflower.databinding.GridItemBinding
import com.pack.safflower.databinding.TableitemLayoutBinding
import com.pack.safflower.model.home.GridData
import com.pack.safflower.model.home.TableData
import com.pack.safflower.model.home.impl.HomeModelImpl

public class HomeViewModel : BaseViewModel() {

    var tabItemsLiveData: MutableLiveData<List<TableData>> = MutableLiveData()
    var gridItemsLiveData: MutableLiveData<List<GridData>> = MutableLiveData()
    var homeModelImpl: HomeModelImpl = HomeModelImpl()
    var mediator: TabLayoutMediator? = null
    var tabView: TabLayout? = null
    var viewPager: ViewPager2? = null
    val titleActiveSize = 15
    val normalSize = 12

    private var activeColor = 0
    private var normalColor = 0

    lateinit var tabBinding: TableitemLayoutBinding
    public lateinit var inflater: LayoutInflater
    /**
     * 获取tabItems持久性数据
     */
    fun getTabItems(): MutableLiveData<List<TableData>> {
        if (homeModelImpl.tabItems != null && homeModelImpl.tabItems.size > 0) {
            tabItemsLiveData.value = homeModelImpl.tabItems
        }
        return tabItemsLiveData;
    }

    /**
     * 设置TabItem
     */
    fun setTabItem(tabView: TabLayout, tabItems: List<TableData>) {
        this.tabView = tabView
        tabBinding = DataBindingUtil.inflate(LayoutInflater.from(mActivity), R.layout.tableitem_layout, null, false)
        inflater = LayoutInflater.from(mActivity)
        activeColor = mActivity!!.resources.getColor(R.color.colorRed)
        normalColor = mActivity!!.resources.getColor(R.color.colorBlack)
    }

    /**
     * 设置TabPageAdapter以及监听滑动时间
     */
    fun setTabPageAdapter(viewPager: ViewPager2, pagerS: List<Fragment>, items: List<TableData>, fm: FragmentManager, lify: Lifecycle) {
        this.viewPager = viewPager
//         禁止预加载
        viewPager.offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
//         设置适配器
        viewPager.setAdapter(object : FragmentStateAdapter(fm, lify) {
            override fun getItemCount(): Int {
                return pagerS.size
            }

            override fun createFragment(position: Int): Fragment {
                return pagerS[position]
            }
        })
//         设置监听
        viewPager.registerOnPageChangeCallback(changeCallback)
//         用来自定义TablayoutItem,将tablayout与viewpage动态链接起来
        mediator = TabLayoutMediator(this.tabView!!, viewPager, TabConfigurationStrategy { tab, position ->
            tab.setCustomView(R.layout.tableitem_layout)
            var tit: TextView = tab.customView!!.findViewById(R.id.tabTitle)
            var msg: TextView = tab.customView!!.findViewById(R.id.tabMsg)
            tit.text = items[position].tabTitle
            tit.textSize = normalSize.toFloat()
            tit.setTextColor(normalColor)
            msg.text = items[position].tabMsg
            msg.textSize = normalSize.toFloat()
            msg.setTextColor(normalColor)
        })
        //要执行这一句才是真正将两者绑定起来
        mediator!!.attach();
    }

    /**
     * ViewPageChange点击回调
     * 设置TabItem选中时的大小
     */
    var changeCallback: ViewPager2.OnPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            //设置选中时tab的大小
            val tabCount: Int = tabView!!.getTabCount()
            for (i in 0 until tabCount) {
                var tab: TabLayout.Tab? = tabView!!.getTabAt(i)
                var tabTitle: TextView = tab!!.customView!!.findViewById(R.id.tabTitle)
                var tabMsg: TextView = tab!!.customView!!.findViewById(R.id.tabMsg)
                if (tab.position == position) {
                    tabTitle.textSize = titleActiveSize.toFloat()
                    tabTitle.setTypeface(Typeface.DEFAULT_BOLD)
                    tabTitle.setTextColor(activeColor)

                    tabMsg.textSize = titleActiveSize.toFloat()
                    tabMsg.setTypeface(Typeface.DEFAULT_BOLD)
                    tabMsg.setTextColor(activeColor)
                } else {
                    tabTitle.textSize = normalSize.toFloat()
                    tabTitle.setTypeface(Typeface.DEFAULT)
                    tabTitle.setTextColor(normalColor)
                    tabMsg.textSize = normalSize.toFloat()
                    tabMsg.setTypeface(Typeface.DEFAULT)
                    tabMsg.setTextColor(normalColor)
                }
            }
        }
    }

    /**
     * 获取网格菜单数据
     */
    fun getGridItems(): MutableLiveData<List<GridData>> {
        if (homeModelImpl.gridS != null && homeModelImpl.gridS.size > 0) {
            gridItemsLiveData.value = homeModelImpl.gridS
        }
        return gridItemsLiveData
    }

    /**
     * 设置菜单适配器
     */
    fun setGridItemAndAdapter(gridItem: GridView, items: List<GridData>) {
        inflater= LayoutInflater.from(mActivity)
        val adapter: GridAdapter = GridAdapter(mActivity,items,gridItem)
        gridItem.adapter=adapter
        adapter.setOnGridItemListener(GridAdapter.OnGridItemLinstener {
            System.out.println("执行"+it)
        })
    }


    public class ImageAdapter internal constructor(private val items: List<Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.banner_item_image, parent, false)
            return ImageViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val imageViewHolder = holder as ImageViewHolder
            Glide.with(imageViewHolder.image)
                    .load(items[position])
                    .apply(RequestOptions()
                            .transform(RoundedCorners(SizeUtils.dp2px(10F))))
                    .into(imageViewHolder.image)
        }

        override fun getItemCount(): Int {
            return items.size
        }

    }

    internal class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView

        init {
            image = itemView.findViewById(R.id.img)
        }
    }

    /**
     * 注销ViewPager2回调
     */
    fun unregisterOnPageChangeCallback() {
        mediator!!.detach();
        viewPager!!.unregisterOnPageChangeCallback(changeCallback)
    }

    fun setGridItemClick(view:GridView) {

    }
}