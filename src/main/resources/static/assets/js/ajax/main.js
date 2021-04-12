let main = {
    init: function () {
        let _this = this;
        $("#btnJoin").on('click', function () {
            console.log('btnJoin');
            _this.signup();
        });

        $('#btnDelete').on('click', function () {
            let id = $('#btnDelete').val();
            _this.deletePost(id);
        });

        $('#btnUpdate').on('click', function () {
            let id = $('#btnUpdate').val();
            _this.updatePost(id);
        });

        $('#btnSave').on('click', function () {
            _this.savePost();
        });

        $('#btn_efficacy_suc').on('click', function () {
            _this.saveEfficacySuc();
        });

        $('#btn_efficacy_role').on('click', function () {
            _this.saveEfficacyRole();
        });

        $('#btn_efficacy_posi').on('click', function () {
            _this.saveEfficacyPositive();
        });

        $('#btn_habit_eat').on('click', function () {
            _this.saveHabitEat();
        });

        $('#btn_habit_sleep').on('click', function () {
            _this.saveHabitSleep();
        });

        $('#btn_habit_workout').on('click', function () {
            _this.saveHabitWorkout();
        });

        $('#btn_stress_like').on('click', function () {
            _this.saveStressLike();
        });

        $('#btn_stress_hate').on('click', function () {
            _this.saveStressHate();
        });

        $('#btn-checkEnv').on('click', function () {
            _this.setUserEnv();
        });

        $('#btn-survey').on('click', function () {
            _this.sendSurvey();
        })
    },

    signup: function () {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let data = {
            id: $('#id').val(),
            password: $('#pswd1').val(),
            passwordConfirm: $('#pswd2').val(),
            name: $('#name').val(),
            birthday: $('#yy').val() + '-' + $('#mm').val() + '-' + $('#dd').val(),
            gender: $('#gender').val(),
            email: $('#email').val(),
            number: $('#number').val()
        };

        $.ajax({
            type: 'POST',
            url: '/signup/registry',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            async: false,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        }).done(function () {
            alert("회원가입 완료");
            location.href = '/login';
        }).fail(function (error) {
            alert(error);
        });
    },

    savePost: function () {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let data = {
            title: $('#title').val(),
            text: $('#text').val()
        };

        $.ajax({
            type: 'POST',
            url: '/board/save',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        }).done(function () {
            alert("등록이 완료되었습니다.");
            location.href = '/board';
        }).fail(function (error) {
            alert(error);
        });
    },

    deletePost: function (id) {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        $.ajax({
            type: 'DELETE',
            url: '/board/delete/' + id,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        }).done(function () {
            alert("삭제가 완료되었습니다.");
            location.href = '/board';
        }).fail(function (error) {
            alert(error);
        });
    },

    updatePost: function (id) {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let data = {
            title: $('#title').val(),
            text: $('#text').val()
        };

        $.ajax({
            type: 'PUT',
            url: '/board/update/' + id,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        }).done(function () {
            alert("수정완료");
            location.href = '/board';
        }).fail(function (error) {
            alert(error);
        });
    },

    saveEfficacySuc: function () {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let data = {
            success: $('#efficacy_suc_text').val()
        };

        $.ajax({
            type: 'POST',
            url: '/state/assignment/efficacy/save/suc',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        }).done(function () {
            alert("등록이 완료되었습니다.");
            location.href = '/state/assignment/efficacy/suc/com';
        }).fail(function (error) {
            alert(error);
        });
    },

    saveEfficacyRole: function () {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let data = {
            rolemodel: $('#efficacy_role_text').val()
        };

        $.ajax({
            type: 'POST',
            url: '/state/assignment/efficacy/save/role',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        }).done(function () {
            alert("등록이 완료되었습니다.");
            location.href = '/state/assignment/efficacy/role/com';
        }).fail(function (error) {
            alert(error);
        });
    },

    saveEfficacyPositive: function () {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let data = {
            positive: $('#efficacy_posi_text').val()
        };

        $.ajax({
            type: 'POST',
            url: '/state/assignment/efficacy/save/positive',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        }).done(function () {
            alert("등록이 완료되었습니다.");
            location.href = '/state/assignment/efficacy/positive/com';
        }).fail(function (error) {
            alert(error);
        });
    },

    saveHabitSleep: function () {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let data = {
            regular: $('#habit_regular_text').val(),
            caffeine: $('#habit_caffeine_text').val(),
            hour: $('#habit_hour_text').val()
        };

        $.ajax({
            type: 'POST',
            url: '/state/assignment/habit/save/sleep',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        }).done(function () {
            alert("등록이 완료되었습니다.");
            location.href = '/state/assignment/habit/sleep/com';
        }).fail(function (error) {
            alert(error);
        });
    },

    saveHabitWorkout: function () {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let data = {
            walking: $('#habit_walking_text').val(),
            stretching: $('#habit_streching_text').val(),
            workout: $('#habit_like_workout_text').val()
        };

        $.ajax({
            type: 'POST',
            url: '/state/assignment/habit/save/workout',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        }).done(function () {
            alert("등록이 완료되었습니다.");
            location.href = '/state/assignment/habit/workout/com';
        }).fail(function (error) {
            alert(error);
        });
    },

    saveHabitEat: function () {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let data = {
            cook: $('#habit_cook_text').val(),
            junk: $('#habit_junk_text').val(),
            onTime: $('#habit_ontime_text').val()
        };

        $.ajax({
            type: 'POST',
            url: '/state/assignment/habit/save/eat',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        }).done(function () {
            alert("등록이 완료되었습니다.");
            location.href = '/state/assignment/habit/eat/com';
        }).fail(function (error) {
            alert(error);
        });
    },

    saveStressHate: function () {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let data = {
            hate: $('#stress_hate_text').val()
        };

        $.ajax({
            type: 'POST',
            url: '/state/assignment/stress/save/hate',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        }).done(function () {
            alert("등록이 완료되었습니다.");
            location.href = '/state/assignment/stress/hate/com';
        }).fail(function (error) {
            alert(error);
        });
    },

    saveStressLike: function () {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let data = {
            favorite: $('#stress_like_text').val()
        };

        $.ajax({
            type: 'POST',
            url: '/state/assignment/stress/save/like',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        }).done(function () {
            alert("등록이 완료되었습니다.");
            location.href = '/state/assignment/stress/like/com';
        }).fail(function (error) {
            alert(error);
        });
    },

    getDropOutVal: function () {
        let result = {
            dropoutTrue: $('#dropout-true').val(),
            dropoutFalse: $('#dropout-false').val()
        };

        if(result.dropoutTrue != null) {
            return true;
        } else if(result.dropoutFalse != null) {
            return false;
        }

        return null;
    },

    getAnxiety: function () {
        let isAnxietyTrue = $('#isAnxietyTrue').val();
        let isAnxietyFalse = $('#isAnxietyFalse').val();

        if(isAnxietyTrue == null) {
            return false;
        } else if(isAnxietyFalse == null) {
            return true;
        }

        return null;
    },

    getCureAnxiety: function () {
        let isCureAnxietyTrue = $('#isCureAnxietyTrue').val();
        let isCureAnxietyFalse = $('#isCureAnxietyFalse').val();
        if(isCureAnxietyTrue == null) {
            return false;
        } else if(isCureAnxietyFalse == null) {
            return true;
        }

        return null;
    },

    getDepression: function () {
        let isDepressionTrue = $('#isDepressionTrue').val();
        let isDepressionFalse = $('#isDepressionFalse').val();

        if(isDepressionTrue == null) {
            return false;
        } else if(isDepressionFalse == null) {
            return true;
        }
        return null;
    },

    getCureDepression: function () {
        let isCureDepressionTrue = $('#isCureDepressionTrue').val();
        let isCureDepressionFalse = $('#isCureDepressionFalse').val();

        if(isCureDepressionTrue == null) {
            return false;
        } else if(isCureDepressionFalse == null) {
            return true;
        }

        return null;
    },

    setUserEnv: function () {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let data = {
            height: $('#height').val(),
            weight: $('#weight').val(),
            grade: $('#grade').val(),
            studyTime: $('#study-time').val(),
            isDropOut: this.getDropOutVal(),
            sleepTime: $('#sleep-time').val(),
            isAnxiety: this.getAnxiety(),
            isCureAnxiety: this.getCureAnxiety(),
            isDepression: this.getDepression(),
            isCureDepression: this.getCureDepression()
        };

        $.ajax({
            type: 'POST',
            url: '/setUserEnv',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            async: false,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        }).done(function () {
            alert("등록이 완료되었습니다.");
            window.location.href = '/test_survey';
        }).fail(function (error) {
            alert(error);
        });
    },


    sendSurvey: function () {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let data = {
            phq1: parseInt($(':radio[name="one"]:checked').val()),
            phq2: parseInt($(':radio[name="two"]:checked').val()),
            phq3: parseInt($(':radio[name="three"]:checked').val()),
            phq4: parseInt($(':radio[name="four"]:checked').val()),
            phq5: parseInt($(':radio[name="five"]:checked').val()),
            phq6: parseInt($(':radio[name="six"]:checked').val()),
            phq7: parseInt($(':radio[name="seven"]:checked').val()),
            phq8: parseInt($(':radio[name="eight"]:checked').val()),
            phq9: parseInt($(':radio[name="nine"]:checked').val())
        }

        $.ajax({
            type: 'POST',
            url: '/survey',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            }
        }).done(function () {
            alert("결과가 등록되었습니다.");
            location.href = '/state';
        }).fail(function (error) {
            alert(error);
        });
    }
};

main.init();