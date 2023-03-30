package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysNotice;

import javax.mail.MessagingException;

/**
 * 公告 服务层
 *
 * @author ruoyi
 */
public interface ISysNoticeService
{
    /**
     * 查询公告信息
     *
     * @param noticeId 公告ID
     * @return 公告信息
     */
    public SysNotice selectNoticeById(Long noticeId);

    /**
     * 查询公告列表
     *
     * @param notice 公告信息
     * @return 公告集合
     */
    public List<SysNotice> selectNoticeList(SysNotice notice);

    /**
     * 新增公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    public int insertNotice(SysNotice notice);

    /**
     * 修改公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    public int updateNotice(SysNotice notice);

    /**
     * 删除公告信息
     *
     * @param noticeId 公告ID
     * @return 结果
     */
    public int deleteNoticeById(Long noticeId);

    /**
     * 批量删除公告信息
     *
     * @param noticeIds 需要删除的公告ID
     * @return 结果
     */
    public int deleteNoticeByIds(Long[] noticeIds);

    /**
     * <pre>
     *     邮件发送业务逻辑接口
     * </pre>
     */
    interface MailService {

        /**
         * 发送邮件
         *
         * @param to      接收者
         * @param title   标题
         * @param content 内容
         */
        void sendMail(String to, String title, String content) throws MessagingException, MessagingException;

    }
}
