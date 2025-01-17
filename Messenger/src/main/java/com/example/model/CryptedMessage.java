package com.example.model;

import java.util.Date;
import java.util.Objects;


import javax.persistence.*;

import com.sun.istack.NotNull;
import net.minidev.json.JSONObject;

@Entity
@Table(name="crypted_message")
public class CryptedMessage implements Message {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageId;

	@Column(name="sender_id")
	@NotNull
	private int sender;

	@Column(name="message")
	@NotNull
	private String message;

	@Column(name="is_checked")
	private boolean isChecked = false;

	@Column(name="is_sended")
	private boolean isSended = false;

	@Column(name="time_of_send")
	@NotNull
	private Date timeOfSend=new Date();


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id", nullable = false)
	private Group group;

	public CryptedMessage() {

	}

	public CryptedMessage(String message,int idGroup, int sender) {
		this.setMessage(message);
		this.sender=sender;
	}
	
//	public CryptedMessage(File image,int idGroup, String sender) {
//		this.image=image;
//		this.idGroup=idGroup;
//		this.sender=sender;
//	}

	public String getMessage() { return message; }

	public void setMessage(String message) { this.message=message; }
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public Date getTimeOfSend() {
		return timeOfSend;
	}
	public void setTimeOfSend(Date timeOfSend) {
		this.timeOfSend = timeOfSend;
	}
	public void messageIsChecked() {
		this.isChecked=true;
	}
	public void messageIsSended() {
		this.isSended=true;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CryptedMessage that = (CryptedMessage) o;
		return messageId == that.messageId && sender == that.sender && isChecked == that.isChecked && isSended == that.isSended && message.equals(that.message) && timeOfSend.equals(that.timeOfSend) && group.equals(that.group);
	}

	@Override
	public int hashCode() {
		return Objects.hash(messageId, sender, message, isChecked, isSended, timeOfSend);
	}

	@Override
	public String toString() {
		return "CryptedMessage{" +
				"messageId=" + messageId +
				", sender='" + sender + '\'' +
				", message='" + message + '\'' +
				", isChecked=" + isChecked +
				", isSended=" + isSended +
				", timeOfSend=" + timeOfSend +
				'}';
	}
}
