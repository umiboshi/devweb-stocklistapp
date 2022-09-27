package model.dao.dto;

import java.sql.Date;

/**
 * stocklistを保持するクラス
 */
public class StockListDTO {
	/**
	 * stocklistのIdを保持する
	 */
	private int id;

	/**
	 * stocklistのnameを保持する
	 */
	private String name;

	/**
	 * stocklistのnumberを保持する
	 */
	private int number;

	/**
	 * stocklistのmemoを保持する
	 */
	private String memo;

	/**
	 * stocklistのupdateを保持する
	 */
	private Date update;
	
	
	/**
	 * stocklistのuserIdを保持する
	 */
	private String userId;

	/**
	 * 引数なしコンストラクタ
	 * 初期化を行う
	 */
	public StockListDTO () {
		id = 0;
		name = "";
		number = 0;
		memo = "";
		update = new Date(System.currentTimeMillis());
		userId ="";
	}

	/**
	 * 受け取った引数によって初期化を行う
	 * @param id
	 * @param name
	 * @param number
	 * @param memo
	 * @param update
	 * @param userId
	 */
	public StockListDTO(int id, String name, int number, String memo,  Date update, String userId) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.memo = memo;
		this.update = update;
		this.userId = userId;
	}

	/**
	 * idを取得する
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * idを設定する
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * nameを取得する
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * nameを設定する
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * numberを取得する
	 * @return number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * numberを設定する
	 * @param memo
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * memoを取得する
	 * @return memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * memoを設定する
	 * @param memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * updateを取得する
	 * @return update
	 */
	public Date getUpdate() {
		return update;
	}

	/**
	 * updateを設定する
	 * @param update
	 */
	public void setUpdate(Date update) {
		this.update = update;
	}
	
	/**
	 * userIdを取得する
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * userIdを設定する
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}