package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

// 싱글톤 디자인 패턴
public class GetMessageListService {
	// static instance 만들어서 계속 사용
	private static GetMessageListService instance = new GetMessageListService();

	public static GetMessageListService getInstance() {
		return instance;
	}

	// 외부에서 객체 생성을 하지 못하게 만들어놓음
	private GetMessageListService() {
	}

	private static final int MESSAGE_COUNT_PER_PAGE = 3;

	public MessageListView getMessageList(int pageNumber) {
		Connection conn = null;
		int currentPageNumber = pageNumber;
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();

			int messageTotalCount = messageDao.selectCount(conn);

			List<Message> messageList = null;
			int firstRow = 0;
			int endRow = 0;
			if (messageTotalCount > 0) {
				firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
				endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
				messageList = messageDao.selectList(conn, firstRow, endRow);
			} else {
				currentPageNumber = 0;
				// 빈 리스트 콜렉션
				messageList = Collections.emptyList();
			}
			return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE,
					firstRow, endRow);
		} catch (SQLException e) {
			throw new ServiceException("목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			// conn을 파라미터로 보내면서 작업하고 마무리할때 conn.close()
			JdbcUtil.close(conn);
		}
	}
}