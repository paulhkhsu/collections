package com.directv.tvapps.common.pojo;
/*
 * @author Paul Hsu
 */
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="USER_ACCOUNT")
@SequenceGenerator(name="user_account_sequence", sequenceName="USER_ACCOUNT_SEQ", allocationSize=1)

@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserAccount extends EntityBase {

	private Long id;
    private Long accountId;
    private String email;
    private String zipCode;
    private boolean testAccount;
    private boolean termsAccepted;    
    private String login;
    private boolean visited;
    private List<Receiver> receivers;
    
	@Id @GeneratedValue  (strategy=GenerationType.SEQUENCE, generator="user_account_sequence")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ACCOUNT_ID", nullable = false)
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Column(name = "EMAIL", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name = "ZIP_CODE")
    public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="USER_ACCOUNT_ID")
    //@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    public List<Receiver> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<Receiver> receivers) {
        this.receivers = receivers;
    }

    @Column(name ="TEST_ACCOUNT", nullable = false)
    public boolean isTestAccount() {
        return testAccount;
    }

    public void setTestAccount(boolean testAccount) {
        this.testAccount = testAccount;
    }

    @Column(name = "TERMS_ACCEPTED", nullable = false)
	public boolean isTermsAccepted() {
		return termsAccepted;
	}

	public void setTermsAccepted(boolean termsAccepted) {
		this.termsAccepted = termsAccepted;
	}

	@Column(name = "login", nullable = true)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name="VISITED", nullable=false)
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
