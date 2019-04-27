var app = angular.module('admin', []);

app.controller("AdminController", function ($scope, $http) {


    $scope.getList = function () {
        $http.get('/rest/admin').success(function (data, status, headers, config) {
            $scope.userList = data;
        }).error(function (data, status, headers, config) {
            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };

    $scope.getGenre = function () {
        $http.get('/rest/admin/genre').success(function (data, status, headers, config) {
            $scope.genreList = data;
        }).error(function (data, status, headers, config) {
            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };

    $scope.getVoice = function () {
        $http.get('/rest/admin/voice').success(function (data, status, headers, config) {
            $scope.voiceList = data;
        }).error(function (data, status, headers, config) {
            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };

    $scope.clear = function () {
        $scope.yearS = "";
        $scope.descriptionS = "";
        $scope.animeNameS = "";
        $scope.genreS = "";
        $scope.voiceS = "";
        $scope.translatorS = "";
        $scope.animeId = "";
        $scope.pictureLinkS = "";
        $scope.videoLinkS = "";
        $scope.year = "";
        $scope.description = "";
        $scope.animeName = "";
        $scope.translator = "";
        $scope.pictureLink = "";
        $scope.videoLink = "";
        $scope.isSearchError = false;
        $scope.isAddError = false;
        $scope.isUpdateError = false;
        $scope.isDeleteError = false;
        $scope.isUpdatedError = false;
        $scope.isDelete = false;
        $scope.isSuccess = false;
        $scope.isUpdated = false;


    };


    $scope.deleteTitle = function (titleName) {

        if (titleName === "") titleName = undefined;

        $http.delete('/rest/admin/deleteTitle/' + titleName).success(function (data, status, headers, config) {
            $scope.clear();
            $scope.isUpateError = false;
            $scope.isDelete = true;

        }).error(function (data, status, headers, config) {
            $scope.errorMessage = data.message;
            $scope.isUpateError = true;
            $scope.isDelete = false;
            console.error(status, data, headers);
        });
    };

    $scope.delete = function (userName) {

        if (userName === "") userName = undefined;

        $http.delete('/rest/admin/delete/' + userName).success(function (data, status, headers, config) {
            for (var i = 0, len = $scope.userList.length; i < len; i++) {
                var j = $scope.userList[i];
                if (j.login === userName) {
                    $scope.userList.splice(i, 1);
                    break;
                }
            }
        }).error(function (data, status, headers, config) {
            $scope.errorMessage = data.message;
            $scope.isAddError = false;
            console.error(status, data, headers);
        });
    };

    $scope.selection = {};
    $scope.gen = {name:'Этти'};
    $scope.vc = 'Anidub';

    $scope.addTitle = function (animeName, pictureLink, videoLink, translator, year, description) {

        if (animeName === "") animeName = undefined;
        if (pictureLink === "") pictureLink = undefined;
        if (translator === "") translator = undefined;
        if (videoLink === "") videoLink = undefined;
        //if ($scope.titleGenre === "") $scope.titleGenre  = undefined;
        // if ($scope.voice === "") $scope.voice = undefined;
        if (description === "") description = undefined;
        if (year === "") year = undefined;

        $http.post('/rest/admin/add/' + animeName + "/" + pictureLink + "/" + videoLink + "/" + translator  + "/" + year + "/" + $scope.selection.selectedmethod.name + "/" + $scope.selection.selectedvoice.name + "/" + description).success(function (data, status, headers, config) {
            $scope.clear();
            $scope.isAddError = false;
            $scope.isSuccess = true;
            }
        ).error(function (data, status) {
            $scope.errorMessage = data.message;
            $scope.isSuccess = false;
            $scope.isAddError = true;
            $scope.isDeleteError = false;
            console.warn("Status code: " + status + "\nError: " + data.message);
        });

    };

    $scope.updateTitle = function (id, animeName, pictureLink, videoLink, translator, year, genre, voice, description) {

        if (animeName === "") animeName = undefined;
        if (pictureLink === "") pictureLink = undefined;
        if (translator === "") translator = undefined;
        if (videoLink === "") videoLink = undefined;
        //if ($scope.titleGenre === "") $scope.titleGenre  = undefined;
        // if ($scope.voice === "") $scope.voice = undefined;
        if (description === "") description = undefined;
        if (year === "") year = undefined;

        $http.post('/rest/admin/update/' + id + "/" + animeName + "/" + pictureLink + "/" + videoLink + "/" + translator  + "/" + year + "/" + genre + "/" + voice + "/" + description).success(function (data, status, headers, config) {
                $scope.isUpdateError = false;
                $scope.clear();
                $scope.isUpdated = true;
            }
        ).error(function (data, status) {
            $scope.errorMessage = data.message;
            $scope.isUpdated = false;
            $scope.isUpateError = true;
            $scope.isAddError = false;
            $scope.isDeleteError = false;
            console.warn("Status code: " + status + "\nError: " + data.message);
        });

    };

    $scope.search = function (name) {

        $http.post('/rest/admin/search/' + name).success(function (data, status, headers, config) {
                $scope.clear();
                $scope.isSearchError = false;
                $scope.yearS = data.year;
                $scope.descriptionS = data.description;
                $scope.animeNameS = data.name;
                $scope.genreS = data.genre.name;
                $scope.voiceS = data.voice.name;
                $scope.translatorS = data.translator;
                $scope.animeId = data.id;
                $scope.pictureLinkS = data.picture.substring(48, data.picture.length);
                $scope.videoLinkS = data.video.substring(48, data.picture.length);


            }
        ).error(function (data, status) {
            $scope.errorMessage = data.message;
            $scope.isSearchError = true;
            console.warn("Status code: " + status + "\nError: " + data.message);
        });
    };


});
