package com.jxd.base.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jxd.base.proxy.clickProxy
import kotlin.math.max
import kotlin.math.min

class JxdBaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

abstract class JxdBaseAdapter<T> : RecyclerView.Adapter<JxdBaseViewHolder>() {
    private val mData = mutableListOf<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JxdBaseViewHolder =
        JxdBaseViewHolder(LayoutInflater.from(parent.context).inflate(layoutId(), parent, false))

    override fun onBindViewHolder(holder: JxdBaseViewHolder, position: Int) {
        if (position >= mData.size) return
        val data = mData[position]
        val view = holder.itemView.apply {
            clickProxy { mItemClickListener?.invoke(data, position) }
        }
        drawItem(view, data, position)
    }

    override fun getItemCount(): Int = mData.size
    abstract fun layoutId(): Int
    abstract fun drawItem(view: View, t: T, position: Int)

    open fun getData() = mData.toList()

    fun refreshData(newList: List<T>) {
        mData.clear()
        mData += newList
        notifyDataSetChanged()
    }

    fun loadMoreData(moreList: List<T>) {
        mData += moreList
        notifyDataSetChanged()
    }

    // 追加 item
    fun appendItem(data: T) {
        val oldSize = mData.size
        mData += data
        notifyItemInserted(oldSize)
    }

    // 插入 item
    fun insertItem(data: T, position: Int = 0) {
        val insertPos = positionVerify(position)
        mData.add(insertPos, data)
        notifyItemInserted(insertPos)
    }

    // 按position移除 item
    fun removeAt(position: Int) {
        val removePos = positionVerify(position)
        removeItem(removePos)
    }

    // 移除item
    fun remove(data: T) {
        val indexOf = mData.indexOf(data)
        val removePos = positionVerify(indexOf)
        removeItem(removePos)
    }

    // 移除item
    private fun removeItem(position: Int) {
        mData.removeAt(position)
        notifyItemRemoved(position)
    }

    /**
     * 增加get 操作符
     * adapter[index] 获取对应元素
     */
    operator fun get(index: Int): T? {
        if (mData.isEmpty()) return null
        if (index < 0) return mData.firstOrNull()
        if (index > mData.size) return mData.lastOrNull()
        return mData[index]
    }


    /**
     * position校验
     * position 需要 大于0 && 小于最大值
     */
    private fun positionVerify(position: Int) = min(max(position, 0), mData.size - 1)

    private var mItemClickListener: ((t: T, position: Int) -> Unit)? = null
    fun onItemClickListener(l: (t: T, position: Int) -> Unit) {
        mItemClickListener = l
    }
}
